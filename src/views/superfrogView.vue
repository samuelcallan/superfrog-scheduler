<template>
    <SuperFrogManagement :userlist="userlist"></SuperFrogManagement>
</template>

<script>
import SuperFrogManagement from '../components/superfrogManagement.vue';
export default {
    data(){
        return {
            userlist: [
                {
                    id: 1,
                    name: "test1",
                    email: "test1@tcu.edu",
                    event: "Birthday Party",
                    bookDate: "2/5/22",
                    time: "1:00 - 3:00 PM",
                    address: "123 Forest Park Blvd",
                    status: "Pending",
                    isPending: true,
                },
                {
                    id: 2,
                    name: "test2",
                    email: "test2@tcu.edu",
                    event: "Birthday Party",
                    bookDate: "2/6/22",
                    time: "1:00 - 3:00 PM",
                    address: "456 McCart Ave",
                    status: "Pending",
                    isPending: true,
                },
                {
                    id: 3,
                    name: "test3",
                    email: "test3@tcu.edu",
                    event: "Birthday Party",
                    bookDate: "2/7/22",
                    time: "1:00 - 3:00 PM",
                    address: "789 University Dr",
                    status: "Pending",
                    isPending: true, 
                },
                {
                    id: 4,
                    name: "test4",
                    email: "test4@tcu.edu",
                    event: "Birthday Party",
                    bookDate: "2/8/22",
                    time: "1:00 - 3:00 PM",
                    address: "123 Wabash Ave",
                    status: "Pending",
                    isPending: true, 
                },
                {
                    id: 5,
                    name: "test5",
                    email: "test5@tcu.edu",
                    event: "Birthday Party",
                    bookDate: "2/9/22",
                    time: "1:00 - 3:00 PM",
                    address: "456 Waits Ave",
                    status: "Pending",
                    isPending: true, 
                }
            ],
        }
    },
    components: {
        SuperFrogManagement
    }
}
</script>