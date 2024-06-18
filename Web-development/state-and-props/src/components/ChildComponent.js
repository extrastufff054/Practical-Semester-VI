import React from 'react';

function ChildComponent(props) {
  return (
    <div>
      <h2>Child Component</h2>
      <p>{props.message}</p>
    </div>
  );
}

export default ChildComponent;
