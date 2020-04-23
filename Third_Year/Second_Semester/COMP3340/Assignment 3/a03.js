window.addEventListener("load", init);

var last_color = 0; //Bit 2 is red, bit 1 is green, bit 0 is blue
var counter = 0;    //counter
var bcolor = 0; //background color, 0 for black, 1 for white


function init ()
{

    document.getElementById("box1").addEventListener("click", box1_click);
    document.getElementById("box3").addEventListener("click", box3_click);
    document.getElementById("box4").addEventListener("click", box4_click);
    document.getElementById("box2").setAttribute("draggable", "true");
    document.getElementById("box2").addEventListener("dragstart", box2_dragstart);
    document.getElementById("box5").addEventListener("drop", box5_drop);
    document.getElementById("box5").addEventListener("dragover", box5_dragover);

}

function box1_click (evt)
{
    if (last_color == 8)
    {
        last_color = 0;
    }
    last_color++;
    var color_to_set = "#";
    color_to_set += (last_color & 4)? "0" : "F";
    color_to_set += (last_color & 2)? "0" : "F";
    color_to_set += (last_color & 1)? "0" : "F";

    var bcolor_to_set = "#";
    bcolor_to_set += (last_color & 4)? "0" : "F";
    bcolor_to_set += (last_color & 2)? "0" : "F";
    bcolor_to_set += (last_color & 1)? "0" : "F";

    this.style.backgroundColor = bcolor_to_set;
    this.style.color = color_to_set;
}
function box3_click (evt)
{
    this.innerHTML = "<p>Count = " + (counter + 1) + ".</p>";
    counter++;
}
function box4_click (evt) 
{
    
    if (bcolor == 0)
    {
        document.documentElement.style.backgroundColor = "black";
        bcolor = 1;
    }
    else
    {
        document.documentElement.style.backgroundColor = "white";
        bcolor = 0;
    }
}
function box2_dragstart (evt)
{
    console.log("dragstart");
    evt.dataTransfer.setData("text/plain", counter);

}
function box5_drop (evt)
{
    evt.preventDefault();
    var data = evt.dataTransfer.getData("text/plain");
    evt.target.innerHTML = "Counter = " + data;

}
function box5_dragover (evt)
{
    evt.preventDefault();
}
