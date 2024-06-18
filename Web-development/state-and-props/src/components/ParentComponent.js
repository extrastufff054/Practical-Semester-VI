import React from 'react';
import ChildComponent from './ChildComponent';

function ParentComponent() {
  const message = "Hello from parent";

  return (
    <div>
      <h1>Parent Component</h1>
      <ChildComponent message={message} />
    </div>
  );
}

export default ParentComponent;
