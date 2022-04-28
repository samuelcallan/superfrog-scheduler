<template>
<div>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">SuperFrog Team Management</h5>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Add SuperFrog Student</button>
                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <form id="addUserForm">
                                <div class="form-group">
                                    <label for="">Student Name</label>
                                    <input type="text" class="form-control" id="student-name" placeholder="Enter name">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputEmail1">Email address</label>
                                    <input type="email" class="form-control" id="student-email" aria-describedby="emailHelp" placeholder="Enter email">
                                    <small id="exampleInputEmail1" class="form-text text-muted">We'll never share your email with anyone else.</small>
                                </div>
                                <div class="form-group">
                                    <label for="">Student Address</label>
                                    <input type="text" class="form-control" id="student-address" placeholder="Enter address">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal" @click="addUser()">Save changes</button>
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
                <th scope="col">Address</th>
                <th></th>
            </tr>
            </thead>
            <tbody id="userTableBody">
                <tr v-for="user in teamlist" :key="user.id">
                    <th scope="row" > {{user.profile.result.id}}</th>
                    <td > {{user.profile.result.name}} </td>
                    <td > {{user.profile.result.email}}  </td>
                    <td > {{user.profile.result.bookingDate}} </td>
                    <td > {{user.profile.result.address}} </td>
                    <td>
                        <button type="button" class="btn btn-danger" @click="deleteFrog(user.id)">Remove</button>
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
            teamlist: []
        }
    },
    mounted(){
        this.retrieve();
    },
    // props: ['teamlist'],
    methods: {
        async retrieve(){
            await axios
            .get('db.json')
            .then(response => (
                this.teamlist = response.data
            ))
        },
        deleteFrog(id) {
            let delIndex;
            for(let i = 0; i < this.teamlist.length; i++){
                if(this.teamlist[i].id == id){
                     delIndex = i;
                }
            }
            this.teamlist.splice(delIndex,1);
        },

        addUser(){
            let newName = document.getElementById("student-name").value;
            let newEmail = document.getElementById("student-email").value;
            let newAddress= document.getElementById("student-address").value;
            console.log(newName);
            console.log(newEmail);
            console.log(newAddress);
            console.log(this.teamlist);

            if(newName != '' && newEmail != '' && newAddress != ''){
                let newUser = [
                    {
                        id: 0,
                        name: '',
                        email: '',
                        bookDate: '',
                        address: '',
                        isActive: true,
                    }
                ];

        
                newUser.id = this.teamlist.length + 1;
                newUser.name = newName;
                newUser.email = newEmail;
                newUser.bookDate = '2/5/20';
                newUser.address = newAddress;
                newUser.isActive = true;

                this.teamlist.push(newUser);
                let form = document.getElementById('addUserForm');
                form.reset();
            }else{
                let form = document.getElementById('addUserForm');
                form.reset();
            }
        }
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

.modal-body{
    color: black;
}
</style>