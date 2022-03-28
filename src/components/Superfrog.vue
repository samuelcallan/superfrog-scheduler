<template>
<div>
  <CustomerManagement :userlist="userlist"></CustomerManagement>
  <TeamManagement :teamlist="teamlist"></TeamManagement>
</div>
</template>

<script>
import CustomerManagement from './customerManagement.vue';
import TeamManagement from './teamManagement.vue';
export default {
    data() {
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
            teamlist: [
              {
                    id: 1,
                    name: "superfrog1",
                    email: "superfrog1@tcu.edu",
                    bookDate: "2/5/22",
                    address: "Tucker Technology Center",
                    isActive: true,
                },
                {
                    id: 2,
                    name: "superfrog2",
                    email: "superfrog2@tcu.edu",
                    bookDate: "2/6/22",
                    address: "Winton Scott",
                    isActive: true,
                },
                {
                    id: 3,
                    name: "superfrog3",
                    email: "superfrog3@tcu.edu",
                    bookDate: "2/7/22",
                    address: "Sid Rich",
                    isActive: true, 
                },
                {
                    id: 4,
                    name: "superfrog4",
                    email: "superfrog4@tcu.edu",
                    bookDate: "2/8/22",
                    address: "Beasley",
                    isActive: true, 
                },
                {
                    id: 5,
                    name: "superfrog5",
                    email: "superfrog5@tcu.edu",
                    bookDate: "2/9/22",
                    address: "Neeley",
                    isActive: true, 
                }
            ],
        };
    },
    components: { CustomerManagement, TeamManagement }
}
</script>

<style>
</style>
