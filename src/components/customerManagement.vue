<template>
<div>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Customer Management</h5>
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
                        <button type="button" class="btn btn-danger" @click="deleteApp(user.profile.result.id)">Remove</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-success" @click="reinstate(user.profile.result.id)">Re-Activate</button>
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
            userlist: []
        }
    },
    mounted(){
        this.retrieve();
    },
    // props: ['userlist'],
    methods: {
         deleteApp(id) {
            for(let i = 0; i < this.userlist.length; i++){
                if(this.userlist[i].profile.result.id == id){
                    this.userlist[i].profile.result.isActive = false;
                }
            }
        },
        reinstate(id){
            for(let i = 0; i < this.userlist.length; i++){
                if(this.userlist[i].profile.result.id == id){
                    this.userlist[i].profile.result.isActive = true;
                }
            }
        },
        async retrieve(){
            await axios
            .get('db.json')
            .then(response => (
                this.userlist = response.data
            ))
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
</style>
