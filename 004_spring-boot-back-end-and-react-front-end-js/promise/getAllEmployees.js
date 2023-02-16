import fetch from "node-fetch";

function getAllEmployees() {
  const url = "http://localhost:8080/api/employees";
  return fetch(url).then((resp) => resp.json());
}

// arr.push({ id: 100, firstName: "Hüseyin", lastName: "Aydın" });
const result = await getAllEmployees();
// Promise 
// console.log(result.then(resp => console.log(resp)));
console.log(result)
