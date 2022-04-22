export default [
    {
      url: '/api/profile',
      method: 'get',
      response: () => {
        return {
          code: 200,
          message: 'Request success',
          type: 'success',
          result: {
            name: 'John',
            age: 18,
            avatar: '/images/tiantan.jpg',
            permissions: ['customer', 'director'],
          },
        };
      },
    },
    {
      url: '/api/auth/login',
      method: 'post',
      timeout: 2000,
      response: () => {
        return {
          code: 200,
          message: 'Login success',
          type: 'success',
          result: {
            token: 'ABCDEFG123oi*&',
          },
        };
      },
    },
  ];
  