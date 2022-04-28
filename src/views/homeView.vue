<template>
    <img src="http://gofrogs.com/common/controls/image_handler.aspx?thumb_id=12&image_path=/images/2018/9/26/SuperFrogSITE_crop_71.jpg" alt="">
<div class="container">
    <div class="test">
        <p>
            <button class="btn btn-lg" type="button" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample" id="pricingButton">
                Pricing
            </button>
        </p>
        <div style="min-height: 120px;">
        <div class="collapse" id="collapseWidthExample">
            <div class="card card-body" style="width: 300px;" id="pricing-text">
            ALL appearances are paid. Prices are based on a 1 hour appearance; additional fees may apply if more than one hour. SuperFrog, Showgirls, and Cheerleaders are individually priced. Payment must be made after receiving an appearance request approval email, and a minimum of 24 hours prior to the event or it will be canceled.
            </div>
        </div>
        </div>
    </div>
    <div class="test2">
        <p>
            <button class="btn btn-lg" type="button" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample2" aria-expanded="false" aria-controls="collapseWidthExample2" id="rangeButton">
                Range
            </button>
        </p>
        <div style="min-height: 120px;">
        <div class="collapse" id="collapseWidthExample2">
            <div class="card card-body" style="width: 200px; height: 150px;" id="range-text">
            We only service requests that are within 100 mile radius from Amon G. Carter Stadium.
            </div>
        </div>
     </div>
    </div>
    <div class="test3">
        <p>
            <button class="btn btn-lg" type="button" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample3" aria-expanded="false" aria-controls="collapseWidthExample3" id="requestButton">
                Requests
            </button>
        </p>
        <div style="min-height: 120px;">
        <div class="collapse" id="collapseWidthExample3">
            <div class="card card-body" style="width: 300px;" id="request-text">
            Request TCU Spirit from a calendar of available dates. Requests must be submitted at least 14 days prior to event date to be considered. Submission of a request does not guarantee the event will be accepted. TCU Spirit has until 5 days prior the date of the event to accept or decline a request.
            <router-link to="/request" class="btn btn-primary" id="router-request">Request Now!</router-link>
            </div>
        </div>
     </div>
    </div>
</div>
</template>


<script>
</script>

<style>
img {
    width: 100%;
    opacity: 80%;
}

.centered {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
}

h1 {
    color: white;
}

#b1 {
    margin-right: 20px;
}

.test{
    position: absolute;
    top: 60%;
    left: 17%;
}

.test2{
    position: absolute;
    top: 60%;
    left: 47%;
}

.test3{
    position: absolute;
    top: 60%;
    left: 76%;
}

#requestButton{
    color: white;
    background-color: #4D1979;
}

#rangeButton{
    color: white;
    background-color: #4D1979;
}

#pricingButton{
    color: white;
    background-color: #4D1979;
}

#router-request{
    margin-top: 20px;
}

#pricing-text{
    text-align: center;
}

#range-text{
    text-align: center;
}

#reqeust-text{
    text-align: center;
}



/* http://gofrogs.com/common/controls/image_handler.aspx?thumb_id=12&image_path=/images/2018/9/26/SuperFrogSITE_crop_71.jpg */


</style>