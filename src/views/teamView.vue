<template>
    <TeamManagement :teamlist="teamlist"></TeamManagement>
</template>

<script>
import TeamManagement from '../components/teamManagement.vue';
export default {
    data(){
        return {
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
        }
    },
    components: {
        TeamManagement
    }
}
</script>

