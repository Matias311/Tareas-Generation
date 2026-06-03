const container = document.getElementById("container");
const baseURL = "https://rickandmortyapi.com/api/character";
const inputSearch = document.getElementById("input-search");
const btnSearch = document.getElementById("btn-search");

async function fetchInfo(URL) {
  try {
    const response = await fetch(URL);
    const data = await response.json();
    return data.results;
  } catch (error) {
    console.log(error);
    return null;
  }
}

const generateCard = ({ name, image, species }) => {
  const container = document.createElement("div");

  const img = document.createElement("img");
  img.src = image;
  container.appendChild(img);

  const title = document.createElement("h2");
  title.innerText = name;
  container.appendChild(title);

  const p = document.createElement("p");
  p.innerText = species;
  container.appendChild(p);

  return container;
};

const searchCharacter = async (valueToSearch) => {
  let data = await fetchInfo(`${baseURL}/?name=${valueToSearch}`);
  console.log(data);
  data.forEach((character) => {
    container.appendChild(generateCard(character));
  });
};

btnSearch.addEventListener("click", () => {
  if (inputSearch.value == "") {
    alert("Tienes que introducir un nombre");
    return;
  }
  container.innerHTML = "";
  searchCharacter(inputSearch.value);
  inputSearch.value = "";
});

const start = async () => {
  let data = await fetchInfo(baseURL);
  data.forEach((character) => {
    container.appendChild(generateCard(character));
  });
};

start();
