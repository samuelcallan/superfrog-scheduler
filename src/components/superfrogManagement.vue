<template>
<div>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">SuperFrog Management</h5>
            </div>
        </div>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Email</th>
                <th scope="col">Event Name</th>
                <th scope="col">Booking Date</th>
                <th scope="col">Start Time</th>
                <th scope="col">End Time</th>
                <th scope="col">Address</th>
                <th scope="col">Status</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody id="userTableBody">
                <tr v-for="user in userlist" :key="user.id">
                    <th scope="row" > {{user.profile.result.id}}</th>
                    <td > {{user.profile.result.name}}  </td>
                    <td > {{user.profile.result.email}}  </td>
                    <td > {{user.profile.result.eventName}}  </td>
                    <td > {{user.profile.result.bookingDate}} </td>
                    <td > {{user.profile.result.start}} </td>
                    <td > {{user.profile.result.end}} </td>
                    <td > {{user.profile.result.address}} </td>
                    <td > {{user.profile.result.status}} </td>
                    <td>
                        <button type="button" class="btn btn-primary" @click="acceptApp(index)">Accept</button>
                    </td>
                    <td>
                        <button type="button" class="btn btn-danger" @click="denyApp(index)">Deny</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</div>
</template>

<script>
import axios from 'axios';
export default {
    data(){
        return{
            userlist: []
        }
    },
    mounted(){
        this.retrieve();
    },
    methods: {
        denyApp(index) {
            this.userlist.splice(index,1);
        },

        acceptApp(index){

        },
        async retrieve(){
            await axios
            .get('db2.json')
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
