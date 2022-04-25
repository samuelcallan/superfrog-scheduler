<template>
<div>
    <div class="container">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Approval Management</h5>
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
                                    <label for="">Superfrog Name</label>
                                    <input type="text" class="form-control" id="superfrog-name" placeholder="Enter name">
                                </div>
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" data-bs-dismiss="modal" @click="selectFrog()">Save Selection</button>
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
                <th scope="col">Event Name</th>
                <th scope="col">Booking Date</th>
                <th scope="col">Time</th>
                <th scope="col">Address</th>
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
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Accept</button>
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
        selectFrog(){
            let newName = document.getElementById("superfrog-name").value;
            console.log(newName);
            console.log(this.userlist);

            if(newName != '' && newEmail != '' && newAddress != ''){
                let newUser = [
                    {
                        id: 0,
                        name: '',
                        email: '',
                        bookDate: '',
                        time: '',
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
    background-color: purple;
    color: white;
}

thead tr{
    background-color: purple;
    border-bottom: 2px solid white;
    color: white;
}
</style>
