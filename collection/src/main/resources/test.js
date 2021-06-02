
var v = '1';
v = 1;
v = f1();


function f1(some) {
    return function () {
        return f1()
    }
}
