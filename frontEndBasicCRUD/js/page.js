// ---------------------------------- check login ---------------------------------- //
function isLogin() {
  var username = storage.getItem("USERNAME");
return (username ? true : false)
}
// ---------------------------------- logout ---------------------------------- //
function logout() {
  window.storage.clear();
  window.location.href = "http://127.0.0.1:5500/html/login.html#";
}
// ---------------------------------- load page parts ---------------------------------- //
// import pages
$(function () {
  if (!isLogin()) {window.location.href = "http://127.0.0.1:5500/html/login.html#"} 

  $(".header").load("header.html", function () {
    document.getElementById("fullName").innerHTML = storage.getItem("FULLNAME");
  });
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
    getListEmployee(1);
  });
}

// ---------------------------------- variables ---------------------------------- //
// initiate deparments array
var departments = [];

// page
var currentPage = 1;

// sort
var isAsc = true;
var currentFieldName = "id";

// ID array for multiple delete
var selectedID = [];

// ---------------------------------- render list ---------------------------------- //
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
  url += "&sort=" + currentFieldName + "," + (isAsc ? "asc" : "desc")

  // page logic
  url += "&page=" + page;
  currentPage = page;

  $.ajax({
    type: "GET",
    url: url,
    contentType: "application/json",
    datatype: 'json',
    beforeSend: function (xhr) {
      xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
    },
    success: function (data, textStatus, xhr){
    departments = data.content;
    departments.forEach(function (item) {
      $("tbody").append(
        `<tr>
            <td><input type="checkbox" value="${item.id}" name="mutipleDelete"></td>
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
  }
})
}

// paging
function renderPaging(totalPages) {
  $('#pagination').empty();

  // previous
  $('#pagination').append(
    `<li class="page-item disable"><a href="#">Previous</a></li>`
  )

  // number of pages
  for (let index = 1; index <= totalPages; index++) {

    $('#pagination').append(
      `<li class="page-item ` + (index == currentPage ? 'active' : '') + `"><a href="#" class="page-link" onclick="getListEmployee(${index})">${index}</a></li>`
    );
  }

  // next
  $('#pagination').append(
    `<li class="page-item"><a href="#" class="page-link">Next</a></li>`
  )
}

// ---------------------------------- delete ---------------------------------- //

function multipleDelete() {
  $("input:checkbox[name=mutipleDelete]:checked").map(function () {
    selectedID.push($(this).val());
  });

  // if the array is empty, open alert
  if (selectedID.length == 0) {
    alert("The selected list is empty");
  }

  // we can also use document.getElementByID
  console.log(selectedID);

  deleteMultipleEmployee(selectedID);

  // empty selected array
  selectedID.length = 0
}


// function checkAll(isChecked) {
// 	if(isChecked) {
// 		$('input[name="language"]').each(function() { 
// 			this.checked = true; 
// 		});
// 	} else {
// 		$('input[name="language"]').each(function() {
// 			this.checked = false;
// 		});
// 	}
// }

// function checkAll() {
//   console.log("check check")
//   $('#checkAll').change(function() {
//     var checkboxes = $(this).closest('form').find(':checkbox');
//     checkboxes.prop('checked', $(this).is(':checked'));
//   });
// }

function deleteMultipleEmployee(selectedID) {
  // api links
  var url = 'http://localhost:8080/api/v1/departments/';

  // parameter logic
  url += '?ids=' + selectedID.toString();

  $.ajax({
    url: url,
    type: 'DELETE',
    beforeSend: function (xhr) {
      xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
    },
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

function deleteEmployee(id) {
  $.ajax({
    url: 'http://localhost:8080/api/v1/departments/' + id,
    type: 'DELETE',
    beforeSend: function (xhr) {
      xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
    },
    success: function (data, textStatus, xhr) {
      getListEmployee();
      // error
      if (result == undefined || result == null) {
        alert("Error when loading data");
        return;
      }
    }
  })
}

function openConfirmDelete(id) {
  // get index from id, why lamda expression returned wrong value?
  for (i = 0; i < departments.length; i++) {
    if (departments[i].id == id) {
      var index = i;
    }
  }
  var name = departments[index].name;

  var result = confirm(`Confirm to delete ${name}?`);
  if (result) {
    deleteEmployee(id);
  }
}
// ---------------------------------- sort, search ---------------------------------- //
function onSort(fieldName) {
  if (currentFieldName != fieldName) {
    isAsc = true;
    currentFieldName = fieldName;
  } else {
    isAsc = !isAsc;
  }
  getListEmployee();
}

function openSearchFunction() {
  getListEmployee();
  // document.getElementById("searchInput").value = "";
}

// ---------------------------------- add new department ---------------------------------- //
function openAddModal() {
  showModal();
}

function addEmployee() {
  // get data from modal
  var id = document.getElementById("id").value;
  var name = document.getElementById("name").value;
  var address = document.getElementById("address").value;
  var emulationPoint = document.getElementById("emulationPoint").value;

  // department object
  department = {
    "id": id,
    "name": name,
    "address": address,
    "emulationPoint": emulationPoint,
  }

  // validation if name exists  
  $.ajax({
    url: 'http://localhost:8080/api/v1/departments/name/' + encodeURIComponent(name),
    type: 'GET', // body
    beforeSend: function (xhr) {
      xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
    },
    success: function (data, textStatus, xhr) {
      if (!data) {

        department = {
          "id": id,
          "name": name,
          "address": address,
          "emulationPoint": emulationPoint,
        }
        // if name not exists, add department
        $.ajax({
          url: 'http://localhost:8080/api/v1/departments',
          type: 'POST',
          data: JSON.stringify(department), // body
          contentType: "application/json", // type of body (json, xml, text)
          // dataType: 'json', // datatype return
          beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
          },
          success: function (data, textStatus, xhr) {
            hideModal();
            getListEmployee();
          },
          error(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
          }
        });

      } else {
        showMessageErrorValidate("Name already used!");
      }
    }
  })
}

// ---------------------------------- update departments ---------------------------------- //
function openUpdateModal(id) {

  // get index from id, why lamda expression returned wrong value?
  for (i = 0; i < departments.length; i++) {
    if (departments[i].id == id) {
      var index = i;
    }
  }

  // fill data
  document.getElementById("id").value = departments[index].id;
  document.getElementById("name").value = departments[index].name;
  document.getElementById("address").value = departments[index].address;
  document.getElementById("emulationPoint").value = departments[index].emulationPoint;

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

function showMessageErrorValidate(message) {
  document.getElementById("error-message").style.display = "block";
  document.getElementById("error-message").innerHTML = message;
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
    beforeSend: function (xhr) {
      xhr.setRequestHeader("Authorization", "Basic " + btoa(storage.getItem("USERNAME") + ":" + storage.getItem("PASSWORD")));
    },
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
  resetForm();
}

// ---------------------------------- modals ---------------------------------- //
// modal functions
function showModal() {
  hideMessageErrorValidate();
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

// ---------------------------------- validate message ---------------------------------- //
function showMessageErrorValidate(message) {
  document.getElementById("error-message").style.display = "block";
  document.getElementById("error-message").innerHTML = message;
}

function hideMessageErrorValidate() {
  document.getElementById("error-message").style.display = "none";
}
