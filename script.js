//問1
function menseki (hankei){
return hankei*hankei*3.14+"c㎡";
}

document.write(menseki(5));
document.write("<br>");
document.write(menseki(7));
document.write("<br>");
document.write(menseki(10));
document.write("<br>");
//問2
function goukei(g,otona,kodomo){
return g+"グループの合計金額は"+(otona*500+kodomo*200)+"円です。";
}

document.write(goukei("A",2,4));
document.write("<br>");
document.write(goukei("B",1,5));
document.write("<br>");
document.write(goukei("C",3,7));
document.write("<br>");