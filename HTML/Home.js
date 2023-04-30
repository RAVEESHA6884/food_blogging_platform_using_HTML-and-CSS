// Slideshow
let slideIndex = 0;
const slides = document.querySelectorAll(".slide");
const dots = document.querySelectorAll(".dot");

function showSlides() {
  for (let i = 0; i < slides.length; i++) {
    slides[i].style.display = "none";  
  }
  slideIndex++;
  if (slideIndex > slides.length) {slideIndex = 1}    
  for (let i = 0; i < dots.length; i++) {
    dots[i].className = dots[i].className.replace(" active", "");
  }
  slides[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " active";
  setTimeout(showSlides, 5000); // Change image every 5 seconds
}

showSlides();

// Search
const searchForm = document.querySelector("#search-form");
const searchInput = document.querySelector("#search-input");
const recipeList = document.querySelector(".recipe-list");

searchForm.addEventListener("submit", function(event) {
  event.preventDefault();
  const searchText = searchInput.value.toLowerCase();
  const recipes = recipeList.querySelectorAll(".recipe");
  for (let recipe of recipes) {
    const title = recipe.querySelector("h3").textContent.toLowerCase();
    const description = recipe.querySelector("p").textContent.toLowerCase();
    if (title.indexOf(searchText) === -1 && description.indexOf(searchText) === -1) {
      recipe.style.display = "none";
    } else {
      recipe.style.display = "block";
    }
  }
  searchInput.value = "";
});
