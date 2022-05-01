import cache from '@/utils/cacheUtils';
import userApi from '@/apis/userApi';
import router from '@/router';
import useUserStore from '@/store/userStore';
import utils from '.';
import autoloadDynamicRoutes from '@/router/loadDynamicRoutes';

// We only considered happy path here...
export async function login(loginInfo) {
  const {
    result: { token },
  } = await userApi.login(loginInfo);

  // We obviously can do this directly:
  // localStorage.setItem('token', token);
  // However, we choose to create an utility object to handle expire time
  cache.set('login_token', { token }, 600); // token is valid for 600 secs

  // Once the user is successfully logged in
  // get user info and save it to Pinia, then we can have access to user's permission list in different components
  const userStore = useUserStore();
  await userStore.getUserInfo();

  // add more route records to the router, e.g., /users and /orders based on user's permission list
  autoloadDynamicRoutes(router);

  //after successful login, redirect to home page or requested page prior login
  const routeName =
    utils.cacheUtils.get('requested_page_prior_login') ?? 'home';

  router.push({ name: routeName });
}

export function logout() {
  cache.remove('login_token');

  // remove user info from Pinia store
  const userStore = useUserStore();
  userStore.userInfo = null;

  // redirect to root page
  router.push('/');
}
