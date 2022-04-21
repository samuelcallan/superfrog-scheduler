const host = '/api/articles';
const findAll = async () => {
  return await fetch(host).then((r) => r.json());
};

const findById = async (id) => {
  return await fetch(`${host}/${id}`).then((r) => r.json());
};

export default { findAll, findById };
