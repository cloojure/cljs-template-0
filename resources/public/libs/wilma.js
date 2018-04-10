
goog.provide('wilmaphony');  // 'wilmaphony' is a "virtual-namespace" that doesn't really exist

wilmaphony.stats  = {  lipstick : "red",  height : 5.5 };  // both are the same
wilmaphony.stats2 = { "lipstick": "red", "height": 5.5 };

wilmaphony.makeWilma = function () {
  var wilma = {};
  wilma.desc = "patient housewife";
  wilma.says = function(name) {
    result = "Hello, " + name;
    return result };
  return wilma;
};
