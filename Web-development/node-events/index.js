const EventEmitter = require('events');
const myEmitter = new EventEmitter();

myEmitter.on('myEvent', () => {
  console.log('myEvent occurred!');
});

myEmitter.on('myEvent', (arg1, arg2) => {
  console.log(`myEvent occurred with args: ${arg1}, ${arg2}`);
});

myEmitter.emit('myEvent');
myEmitter.emit('myEvent', 'arg1 value', 'arg2 value');
