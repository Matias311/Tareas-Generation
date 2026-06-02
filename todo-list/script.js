const container = document.getElementById("container");
const inputTask = document.getElementById("inputTask");
const btnSubmit = document.getElementById("btnSubmit");

const createTask = (title) => {
  const containerCard = document.createElement("div");

  const titleCard = document.createElement("h2");
  titleCard.innerText = title;
  containerCard.appendChild(titleCard);

  const btnDelete = document.createElement("button");
  btnDelete.type = "button";
  btnDelete.innerText = "Eliminar";
  btnDelete.addEventListener("click", (e) => deleteTask(e));
  containerCard.appendChild(btnDelete);

  container.appendChild(containerCard);
};

const deleteTask = (e) => {
  e.target.parentElement.remove();
};

btnSubmit.addEventListener("click", () => {
  if (inputTask.value == "") {
    alert("El nombre de la tarea no puede estar vacio");
    return;
  }
  createTask(inputTask.value);
  inputTask.value = "";
});
