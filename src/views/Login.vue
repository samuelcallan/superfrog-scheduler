<template>
<div class="container">
    <section class="vh-100">
    <div class="container-fluid">
        <div class="row">
        <div class="col-sm-6 text-black">
            <div class="d-flex align-items-center h-custom-2 px-5 ms-xl-4 mt-5 pt-5 pt-xl-0 mt-xl-n5">
            <Form 
            :validation-schema="validationSchema" 
            style="width: 23rem;" 
            v-slot:default="{ errors }">
                <h3 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Log in</h3>
                <div class="form-outline mb-4">
                <Field 
                class="form-control form-control-lg" 
                name="account"
                as="input"
                type="text"
                label="Account name"
                placeholder="Input your account email"
                id="form2Example18" 
                />
                <div v-if="errors.account">
                  Account name must be a valid email address
                </div>
                <label class="form-label" for="form2Example18">Email address</label>
                </div>
                <div class="form-outline mb-4">
                <Field 
                name="password"
                as="input"
                type="password"
                :validate-on-input="true"
                label="Password"
                placeholder="Input your password"
                id="form2Example28" 
                class="form-control form-control-lg" 
                />
                <div v-if="errors.account">
                  Account name must be a valid email address
                </div>
                <label class="form-label" for="form2Example28">Password</label>
                </div>

                <div class="pt-1 mb-4">
                <button class="btn btn-lg btn-block" type="button" id="login" @click="login">Login</button>
                </div>

                <p class="small mb-5 pb-lg-2"><a class="text-muted" href="#!">Forgot password?</a></p>
                <p>Don't have an account? <a href="#!" class="link-info" id="register">Register here</a></p>
            </Form>
            </div>
        </div>
        <div class="col-sm-6" id="picture">
            <img src="https://pbs.twimg.com/profile_images/1063084325455958016/DD5wUtCp_400x400.jpg"
            alt="Login image" class="w-100 vh-100" style="object-fit: cover; object-position: left;">
        </div>
        </div>
    </div>
    </section>
</div>
</template>

<script>
import v from '@/plugins/validation'
import { Form, Field } from 'vee-validate';
import utils from '@/utils';
export default{
   data() {
    return {
      validationSchema: v.yup.object({
        account: v.yup.string().required().email().label('Account name'),
        password: v.yup.string().required().min(3).label('Password'),
      }),
    };
  },
  components: {
    Form,
    Field,
  },
  methods: {
    async login(values) {
      utils.userLoginUtils.login(values);
    },
  },
};
</script>

<style>
#picture{
    margin-bottom: 50px;
}
#login{
    background-color: purple;
    color: white;
}

#register{
    color: purple;
}
</style>