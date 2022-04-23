<template>
<div class="container">
    <img src="http://gofrogs.com/common/controls/image_handler.aspx?thumb_id=12&image_path=/images/2018/9/26/SuperFrogSITE_crop_71.jpg" alt="">
    <div class="test">
        <p>
            <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample">
                Toggle width collapse
            </button>
        </p>
        <div style="min-height: 120px;">
        <div class="collapse collapse-horizontal" id="collapseWidthExample">
            <div class="card card-body" style="width: 300px;">
            This is some placeholder content for a horizontal collapse. It's hidden by default and shown when triggered.
            </div>
        </div>
        </div>
    </div>
    <div class="test2">
        <p>
            <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample">
                Toggle width collapse
            </button>
        </p>
        <div style="min-height: 120px;">
        <div class="collapse collapse-horizontal" id="collapseWidthExample">
            <div class="card card-body" style="width: 300px;">
            This is some placeholder content for a horizontal collapse. It's hidden by default and shown when triggered.
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
    left: 20%;
}

.test2{
    position: absolute;
    top: 60%;
    left: 70%;
}

/* http://gofrogs.com/common/controls/image_handler.aspx?thumb_id=12&image_path=/images/2018/9/26/SuperFrogSITE_crop_71.jpg */


</style>