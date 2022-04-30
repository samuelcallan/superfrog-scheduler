<template>
<div>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Customer Management</h5>
                <!-- Edit a user dialog -->
    <div class="modal fade" id="editUserDialog" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Edit a User</h5>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          </div>
          <div class="modal-body">
            <form>
              <div class="form-group row">
                <label for="username-edit" class="col-sm-2 col-form-label">Name</label>
                <div class="col-sm-10">
                  <input type="text" readonly class="form-control-plaintext" id="username-edit" value="" />
                </div>
              </div>
              <div class="form-group row">
                <label for="email-edit" class="col-sm-2 col-form-label">Email</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="email-edit" value="" />
                </div>
              </div>
              <div class="form-group row">
                <label for="bookingdate-edit" class="col-sm-2 col-form-label">Booking Date</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="bookingdate-edit" value="" />
                </div>
              </div>
              <div class="form-group row">
                <label for="address-edit" class="col-sm-2 col-form-label">Address</label>
                <div class="col-sm-10">
                  <input type="text" class="form-control" id="address-edit" value="" />
                </div>
              </div>
            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
              Close
            </button>
            <button type="button" class="btn btn-primary" onclick="updateUser()">
              Save changes
            </button>
          </div>
        </div>
      </div>
    </div>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Booking Date</th>
                <th scope="col">isActive</th>
                <th scope="col">Address</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody id="userTableBody">
                <tr v-for="user in userlist" :key="user.id">
                    <th scope="row"> {{user.profile.result.id}}</th>
                    <td> {{user.profile.result.name}}  </td>
                    <td> {{user.profile.result.email}}  </td>
                    <td> {{user.profile.result.bookingDate}} </td>
                    <td> {{user.profile.result.isActive}} </td>
                    <td> {{user.profile.result.address}} </td>
                    <td> 
                        <button type="button" class="btn btn-info" data-bs-toggle="modal" data-bs-target="editUserDialog" @click="showEditDialog(user.id)">Edit</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-danger" @click="deleteApp(user.id)">Remove</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-success" @click="reinstate(user.id)">Re-Activate</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
</template>

<script>
import axios from "axios";
export default {
    data(){
        return{
            userlist: [],
            editForm: {
                id: '',
                name: '',
                email: '',
                bookingDate: '',
                address: '',
            },
        }
    },
    mounted(){
        this.retrieve();
    },
    props: ['userlist', 'editForm'],
    methods: {
        deleteApp(id) {
            for(let i = 0; i < this.userlist.length; i++){
                if(this.userlist[i].id == id){
                     this.userlist[i].isActive = false;
                }
            }
        },
        reinstate(id){
            for(let i = 0; i < this.userlist.length; i++){
                if(this.userlist[i].id == id){
                     this.userlist[i].isActive = true;
                }
            }
        },
        async retrieve(){
            await axios
            .get('db.json')
            .then(response => (
                this.userlist = response.data
            ))
        },
        showEditDialog(userId) {
            var name = document.getElementById("username-edit");
            var email = document.getElementById("email-edit");
            var bookingDate = document.getElementById("bookingdate-edit");
            var address = document.getElementById('address-edit');
            for (var i = 0; i < data.length; i++) {
                if (data[i].id == userId) {
                    email.value = data[i].email;
                    name.value = data[i].name;
                    bookingDate.value = data[i].bookingDate;
                    address.value = data[i].address;

                }
            }
            editForm.id = userId;
         },
        updateUser() {
            var email = document.getElementById("email-edit");
            var bookingDate = document.getElementById("bookingdate-edit");
            var address = document.getElementById('address-edit');
            var userId = editForm.id;
            for (var i = 0; i < data.length; i++) {
                if (data[i].id == userId) {
                    data[i].email = email.value;
                    data[i].bookingDate = bookingDate.value;
                    data[i].address = address.value;
                }
            }
            editForm.id = '';
            editForm.name = '';
            editForm.email = '';
            editForm.bookingDate = '';
            editForm.address = '';
        },
    }
};
</script>

<style>
.card{
    margin-top: 10px;
}
.card-body{
    background-color: #4D1979;
    color: white;
}

thead tr{
    background-color: #4D1979;
    border-bottom: 2px solid white;
    color: white;
}
</style>
