<template>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
/>
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
                <th scope="col">Address</th>
                <th></th>
            </tr>
            </thead>
            <tbody id="userTableBody">
                <tr v-for="user in userlist" :key="user.id">
                    <th scope="row" v-if="user.isActive"> {{user.id}}</th>
                    <td v-if="user.isActive"> {{user.name}}  </td>
                    <td v-if="user.isActive"> {{user.email}}  </td>
                    <td v-if="user.isActive"> {{user.bookDate}} </td>
                    <td v-if="user.isActive"> {{user.address}} </td>
                    <td>
                        <button type="button" class="btn btn-danger" @click="deleteApp(index)">Remove</button>
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
    deleteApp(index) {
        this.userlist.splice(index,1);
    }
    }
};
</script>

<style>
.card{
    margin-top: 10px;
}
.card-body{
    background-color: purple;
    color: white;
}

thead tr{
    background-color: purple;
    border-bottom: 2px solid white;
    color: white;
}

</style>
