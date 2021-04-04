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

// initiate employees array
var employees = [];

function getListEmployee() {
  // empty the old data first
  $('tbody').empty();
  $.get("https://6060430004b05d0017ba22b2.mockapi.io/api/v1/Employee", function (data, status) {
    employees = data;
    employees.forEach(function (item) {
      $("tbody").append(
        `<tr>
            <td>${item.id}</td>
            <td>
              <a href="#">${item.name}</a>
            </td>
            <td>${item.createDate}</td>
            <td>${item.role}</td>
            <td><span class="status text-success">&bull;</span> ${item.status
        }</td>
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
  })
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
  document.getElementById("createDate").value = employees[index].createDate;
  document.getElementById("role").value = employees[index].role;
  document.getElementById("status").value = employees[index].status;

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

  $.ajax({
    url: 'https://6060430004b05d0017ba22b2.mockapi.io/api/v1/Employee/' + id,
    type: 'PUT',
    data: employee,
    success: function (result) {
      // error
      if (result == undefined || result == null) {
        alert("Error when loading data");
        return;
      }

      // success
      hideModal();
      getListEmployee();
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
    url: 'https://6060430004b05d0017ba22b2.mockapi.io/api/v1/Employee/' + id,
    type: 'DELETE',
    success: function(result) {
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
  document.getElementById("createDate").value = "";
  document.getElementById("role").value = "";
  document.getElementById("status").value = "";
}

