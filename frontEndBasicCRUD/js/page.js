// import pages
$(function () {
  $(".header").load("header.html");
  $(".main").load("home.html");
  $(".footer").load("footer.html");
});

// load Navigation
function clickNavHome() {
  $(".main").load("home.html");
}

function clickNavListEmployee() {
  // load table first then load data
  $(".main").load("listEmployee.html", function () {
    getListEmployee();
  });
}

// initiate deparments array
var departments = [];

// page
var currentPage = 1;

// sort
var isAsc = true;
var currentFieldName = "id";

function getListEmployee(page) {
  // empty the old data first
  $('tbody').empty();

  // links
  var url = "http://localhost:8080/api/v1/departments";

  // get search input
  var search = document.getElementById("searchInput").value;

  // search logic
    url += "?search=" + search;
  

  // sort logic
  url += "&sort=" + currentFieldName + "," + (isAsc? "asc" : "desc")

  // page logic
  url += "&page=" + page;
  currentPage = page;

  $.get(url, function (data, status) {
    departments = data.content;
    departments.forEach(function (item) {
      $("tbody").append(
        `<tr>
            <td>${item.id}</td>
            <td>
              <a href="#">${item.name}</a>
            </td>
            <td>${item.address}</td>
            <td>${item.emulationPoint}</td>
            </td>
            <td>
              <a
                href="#"
                class="settings"
                title="Settings"
                data-toggle="tooltip"
                onClick = "openUpdateModal(${item.id})"
                ><i class="material-icons">&#xE8B8;</i></a
              >
              <a href="#" class="delete" title="Delete" data-toggle="tooltip" onClick ="openConfirmDelete(${item.id})"
                ><i class="material-icons">&#xE5C9;</i></a
              >
            </td>
          </tr>`
      );
    })
    // get total pages
    renderPaging(data.totalPages);
  })
}

function renderPaging(totalPages){
  $('#pagination').empty();

  // previous
  $('#pagination').append(
    `<li class="page-item disable"><a href="#">Previous</a></li>`
  )

  // number of pages
  for (let index = 1; index <= totalPages; index++) {
   
      $('#pagination').append(
        `<li class="page-item ` +(index==currentPage? 'active': '')+ `"><a href="#" class="page-link" onclick="getListEmployee(${index})">${index}</a></li>`
      );
  
    // else {
    //   $('#pagination').append(
    //     `<li class="page-item"><a href="#" class="page-link" onclick="getListEmployee(${index})">${index}</a></li>`
    //   );
    // }
  }

  // next
  $('#pagination').append(
    `<li class="page-item"><a href="#" class="page-link">Next</a></li>`
  )
}

function onSort(fieldName){
  if(currentFieldName != fieldName){
      isAsc = true;
      currentFieldName = fieldName;
  }else{
      isAsc = !isAsc;
  }
  getListEmployee();
}

function openSearchFunction() {
  getListEmployee();
  // document.getElementById("searchInput").value = "";
}

function openAddModal() {
  showModal();
}

function addEmployee() {
  var name = document.getElementById("name").value;
  var createDate = document.getElementById("createDate").value;
  var role = document.getElementById("role").value;
  var status = document.getElementById("status").value;
  // TODO validate

  employee = {
    "name": name,
    "createDate": createDate,
    "role": role,
    "status": status,
  }

  $.post("https://6060430004b05d0017ba22b2.mockapi.io/api/v1/Employee", employee,
    function (data, status) {
      // error
      if (status == "error") {
        alert("Error when loading data");
        return;
      }

      // success
      hideModal();
      getListEmployee();
    });

}

function openUpdateModal(id) {

  // get index from id, why lamda expression returned wrong value?
  for (i = 0; i < employees.length; i++) {
    if (employees[i].id == id) {
      var index = i;
    }
  }

  // fill data
  document.getElementById("id").value = employees[index].id;
  document.getElementById("name").value = employees[index].name;
  document.getElementById("address").value = employees[index].address;
  document.getElementById("emulationPoint").value = employees[index].emulationPoint;

  showModal();
}

function save() {
  var id = document.getElementById("id").value;
  if (id == null || id == "" || id == undefined) {
    addEmployee();
  } else {
    updateEmployee();
  }
}

function updateEmployee() {
  var id = document.getElementById("id").value;
  var name = document.getElementById("name").value;
  var address = document.getElementById("address").value;
  var emulationPoint = document.getElementById("emulationPoint").value;
  // TODO validate

  department = {
    "id": id,
    "name": name,
    "address": address,
    "emulationPoint": emulationPoint
  }

  $.ajax({
    url: 'http://localhost:8080/api/v1/departments/' + id,
    type: 'PUT',
    data: JSON.stringify(department), // body
    contentType: "application/json", // type of body (json, xml, text)
    // dataType: 'json', // datatype return
    success: function (data, textStatus, xhr) {
      hideModal();
      getListEmployee()
    },
    error(jqXHR, textStatus, errorThrown) {
      console.log(jqXHR);
      console.log(textStatus);
      console.log(errorThrown);
    }
  });
}

function openConfirmDelete(id) {
  // get index from id, why lamda expression returned wrong value?
  for (i = 0; i < employees.length; i++) {
    if (employees[i].id == id) {
      var index = i;
    }
  }
  var name = employees[index].name;

  var result = confirm(`Confirm to delete ${name}?`);
  if (result) {
    deleteEmployee(id);
  }
}

function deleteEmployee(id) {
  $.ajax({
    url: 'http://localhost:8080/api/v1/departments/' + id,
    type: 'DELETE',
    success: function (result) {
      // error
      if (result == undefined || result == null) {
        alert("Error when loading data");
        return;
      }

      // success
      getListEmployee();
    }
  })
}

// modal functions
function showModal() {
  $("#myModal").modal("show");
}

function hideModal() {
  $("#myModal").modal("hide");
  resetForm();
}

function resetForm() {
  document.getElementById("id").value = "";
  document.getElementById("name").value = "";
  document.getElementById("address").value = "";
  document.getElementById("emulationPoint").value = "";
}