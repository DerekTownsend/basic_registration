// nav js
let icon = document.getElementById("icon");
let nav= document.getElementById("myTopNav");

icon.addEventListener("click",() =>{
  if (!nav.classList.contains("responsive")){
    nav.classList.add("responsive");
  } else{
    nav.classList.remove("responsive")
  }
  
});
