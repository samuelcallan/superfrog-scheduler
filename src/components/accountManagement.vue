<template>
<div class="container rounded bg-white mt-5 mb-5">
        <div class="row">
            <div class="col-md-5 border-right mx-auto">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-3">
                        <h4 class="text-right">Profile Settings</h4>
                    </div>
                    <div class="row mt-2">
                        <div class="col-md-6"><label class="labels">First Name</label><input readonly type="text" class="form-control" placeholder="first name" :value="user.first"></div>
                        <div class="col-md-6"><label class="labels">Last Name</label><input readonly type="text" class="form-control" :value="user.last" placeholder="last name"></div>
                    </div>
                    <div class="row mt-3">
                        <div class="col-md-12"><label class="labels">Mobile Number</label><input readonly type="text" class="form-control" placeholder="enter phone number" :value="user.phone"></div>
                        <div class="col-md-12"><label class="labels">Email</label><input readonly type="text" class="form-control" placeholder="enter email" :value="user.email"></div>
                    </div>
                    <div class="mt-5 text-center">
                        <button class="btn btn-warning" type="button" @click="edit">Edit Profile</button>
                    </div>
                    <div class="mt-3 text-center">
                        <button class="btn btn-primary" type="button" @click="save">Update Profile</button>
                    </div>
                </div>
            </div>
        </div>
</div>
</template>


<script>
import axios from 'axios';
export default {
    data(){
        return {
            data: null,
            isLoaded: false,
            user: {
                first: '',
                last: '',
                phone: '',
                email: ''
            },
        };
    },
    mounted(){
        this.getData();
    },
    methods: {
        async getData(){
            await axios
            .get('db.json')
            .then(response => (
                this.user.first = response.data.profile.result.first,
                this.user.last = response.data.profile.result.last,
                this.user.phone = response.data.profile.result.phone,
                this.user.email = response.data.profile.result.email
                )
            )
        },

        edit(){
            let elements = [];
            elements = document.getElementsByClassName('form-control');
            for(let i = 0; i < elements.length; i++){
                elements[i].readOnly = false;
            }
        },
        save(){
            let elements = [];
            elements = document.getElementsByClassName('form-control');
            for(let i = 0; i < elements.length; i++){
                elements[i].readOnly = true;
            }
        }
    }
}

</script>


<style>
</style>