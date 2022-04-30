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
                <th scope="col">Time</th>
                <th scope="col">Address</th>
                <th></th>
                <th></th>
            </tr>
            </thead>
            <tbody id="userTableBody">
                <tr v-for="user in userlist" :key="user.id">
                    <th scope="row" v-if="user.isPending"> {{user.id}}</th>
                    <td v-if="user.isPending"> {{user.name}}  </td>
                    <td v-if="user.isPending"> {{user.email}}  </td>
                    <td v-if="user.isPending"> {{user.event}} </td>
                    <td v-if="user.isPending"> {{user.bookDate}} </td>
                    <td v-if="user.isPending"> {{user.time}} </td>
                    <td v-if="user.isPending"> {{user.address}} </td>
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
export default {
    props: ['userlist'],
    methods: {
        denyApp(index) {
            this.userlist.splice(index,1);
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
