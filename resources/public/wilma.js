goog.provide('flintstones.chars.wilma');  // 'wlma' is a "virtual-namespace" that doesn't really exist

flintstones.chars.wilma.stats = { "lipstick": "red", "height": 5.5 };
flintstones.chars.wilma.makeWilma = function () {
  var wilma = {};
  wilma.desc = "patient housewife";
  wilma.says = function(name) {
    result = "Hello, " + name;
    return result };
  return wilma;
};
