// debounce function(防抖动函数)
// which let the frequent request result in the synthesize all request and show by the last request
export function debounce(func, delay) {

    let timer = null;

    // if next function is so fast that this function isn't finish, debounce() will clear the process in this function at first and do it together in next function(now function)
    return function(...args) {
      if(timer){
        clearTimeout(timer);
      }
      timer = setTimeout(() => {
        func.apply(this, args);
      }, delay)
    };

}
