<template>
<div class="scheduler">
  <UserManagement :list="list"></UserManagement>
</div>
</template>


<script>
import UserManagement from './userManagement.vue';
export default {
    data() {
        return {
            username: "supefrog",
            list: [
                {
                    id: 1,
                    name: "test1",
                    email: "person@tcu.edu",
                    bookDate: "2/5/22",
                    address: "123 Forest Park Blvd",
                    isActive: true,
                },
                {
                    id: 2,
                    name: "test2",
                    email: "teacher@tcu.edu",
                    bookDate: "2/6/22",
                    address: "456 McCart Ave",
                    isActive: true,
                },
                {
                    id: 3,
                    name: "test3",
                    email: "bing@tcu.edu",
                    bookDate: "2/7/22",
                    address: "456 McCart Ave",
                    isActive: true, 
                },
                {
                    id: 4,
                    name: "test4",
                    email: "scherg@tcu.edu",
                    bookDate: "2/8/22",
                    address: "456 McCart Ave",
                    isActive: true, 
                },
                {
                    id: 5,
                    name: "test5",
                    email: "sanchez@tcu.edu",
                    bookDate: "2/9/22",
                    address: "456 McCart Ave",
                    isActive: true, 
                }
            ]
        };
    },
    components: { UserManagement }
}
</script>

<style>
</style>
