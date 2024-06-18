import React, { useState, useEffect } from 'react';
import axios from 'axios';

function DataList() {
  const [data, setData] = useState([]);
  const [name, setName] = useState('');
  const [age, setAge] = useState('');
  const [id, setId] = useState(null);

  useEffect(() => {
    axios.get('http://localhost:3001/api/data')
      .then(response => setData(response.data))
      .catch(error => console.error(error));
  }, []);

  const handleCreate = () => {
    axios.post('http://localhost:3001/api/data', { name, age })
      .then(response => setData([...data, response.data]))
      .catch(error => console.error(error));
  };

  const handleUpdate = () => {
    axios.put(`http://localhost:3001/api/data/${id}`, { name, age })
      .then(response => setData(data.map(item => (item.id === id ? response.data : item))))
      .catch(error => console.error(error));
  };

  const handleDelete = () => {
    axios.delete(`http://localhost:3001/api/data/${id}`)
      .then(() => setData(data.filter(item => item.id !== id)))
      .catch(error => console.error(error));
  };

  return (
    <div>
      <h1>Data List</h1>
      <ul>
        {data.map(item => (
          <li key={item.id}>
            {item.name} ({item.age})
            <button onClick={() => setId(item.id)}>Edit</button>
            <button onClick={() => handleDelete()}>Delete</button>
          </li>
        ))}
      </ul>
      <form>
        <label>
          Name:
          <input type="text" value={name} onChange={e => setName(e.target.value)} />
        </label>
        <label>
          Age:
          <input type="number" value={age} onChange={e => setAge(e.target.value)} />
        </label>
        <button onClick={handleCreate}>Create</button>
        {id ? (
          <button onClick={handleUpdate}>Update</button>
        ) : (
          <button onClick={() => setId(null)}>Reset</button>
        )}
      </form>
    </div>
  );
}

export default DataList;