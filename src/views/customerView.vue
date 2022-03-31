<template>
    <CustomerManagement :userlist="userlist"></CustomerManagement>
</template>

<script>
import CustomerManagement from '../components/customerManagement.vue';
export default {
    data(){
        return {
            userlist: [
                {
                    id: 1,
                    name: "test1",
                    email: "test1@tcu.edu",
                    bookDate: "2/5/22",
                    address: "123 Forest Park Blvd",
                    isActive: true,
                },
                {
                    id: 2,
                    name: "test2",
                    email: "test2@tcu.edu",
                    bookDate: "2/6/22",
                    address: "456 McCart Ave",
                    isActive: true,
                },
                {
                    id: 3,
                    name: "test3",
                    email: "test3@tcu.edu",
                    bookDate: "2/7/22",
                    address: "789 University Dr",
                    isActive: true, 
                },
                {
                    id: 4,
                    name: "test4",
                    email: "test4@tcu.edu",
                    bookDate: "2/8/22",
                    address: "123 Wabash Ave",
                    isActive: true, 
                },
                {
                    id: 5,
                    name: "test5",
                    email: "test5@tcu.edu",
                    bookDate: "2/9/22",
                    address: "456 Waits Ave",
                    isActive: true, 
                }
            ],
        }
    },
    components: {
        CustomerManagement
    }
}
</script>