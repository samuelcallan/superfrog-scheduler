<template>
<div class="container">
    <form>
        <div class="form-group">
            <label for="exampleInputEmail1" id="eventName">Event Title</label>
            <input type="text" class="form-control" id="exampleInputEmail1" :value="newEvent.name" aria-describedby="emailHelp" placeholder="Enter Event Name">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Name of Organization</label>
            <input type="text" class="form-control" id="exampleInputPassword1" placeholder="Event Name">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Address of Event Location</label>
            <input type="text" class="form-control" id="exampleInputPassword1" :value="newEvent.location" placeholder="Event Location">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Event Date</label>
            <Datepicker v-model="date" ref="dp" :value="newEvent.date">
                <template #action-preview="{ value }">
                    {{ getDate(value) }}
                </template>
            </Datepicker>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Start Time</label>
            <input type="time" id="start" name="appt" min="09:00" max="18:00" :value="newEvent.start" required>
            <div class="endTime">
                <label for="exampleInputPassword1">End Time</label>
                <input type="time" id="end" name="appt" min="09:00" max="18:00" :value="newEvent.end" required>
            </div>
        </div>
    </form>

<!--Section: Contact v.2-->
    <section class="mb-4">
        <div class="row">
            <div class="col-md-9 mb-md-0 mb-5">
                <form id="contact-form" name="contact-form" action="mail.php" method="POST">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="md-form">
                                <textarea type="text" id="message" name="message" rows="2" class="form-control md-textarea"></textarea>
                                <label for="message">Event Description</label>
                            </div>

                        </div>
                    </div>
                </form>
                <div class="status"></div>
            </div>
        </div>
    </section>
    <div class="text-center text-md-left">
                    <a class="btn btn-primary" @click="sendData">Send</a>
    </div>
</div>

</template>

<script>
import Datepicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css'
import { ref } from 'vue';
import axios from 'axios';

export default {
    data(){
        return{
            data: null,
            isLoaded: false,
            newEvent:{
                name:'',
                location: '',
                date: '',
                start: '',
                end: '',
            }
        }
    },
    setup() {
        const date = ref(new Date());
        const dp = ref();
        
        const getDate = (dateVal) => {
            const newDate = new Date(dateVal);

            return `Selected ${newDate.getDate()}`;
        }
        
        return {
            date,
            dp,
            getDate,
        }
    },
    components:{
        Datepicker
    },
    methods:{
        async sendData(){
            const eventData = {
				 name: eventData.name,
                 location: eventData.location,
                 date: eventData.date,
                 start: eventData.start,
                 end: eventData.end,

			 }
            await axios.post('', eventData)
             .then(response => (
                console.log(response)
            ))
        }
    }
}
</script>

<style>
.container{
    margin-top: 50px;
    margin-bottom: 50px;
}

 .custom-select {
      cursor: pointer;
      color: var(--c-text-accent);
      margin: 0;
      display: inline-block;
}

.form-group{
    margin-bottom: 20px;
}

.endTime{
    margin-top: 10px;
}
#start{
    margin-left: 20px;
}

#end{
    margin-left: 28px;
}

</style>