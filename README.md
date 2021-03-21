# RoverBot

use this in input for http://localhost:8080/RoverBot/getFinalPosition

{
  "position":{
    "direction":"N",
    "x":10,
    "y":10
},
"move":[
  {
    "o":"1",
    "l":90,
    "f":10
  },
  {
    "o":"2",
    "r":180,
    "b":20
  }
        ]
}

* output would be

{
  “Position”: {
      “Direction”: “E”,
      “X” : “-20”,
      “Y”: “10”
    }
}
