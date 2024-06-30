## 1. Create a new React project (if you don't have one already)

Open your terminal or command prompt and run the following command to create a new React project using Create React App:

```bash
npx create-react-app my-form-app
```

This will create a new directory called `my-form-app` with the necessary files and dependencies for a React project.

## 2. Navigate to the project directory

```bash
cd my-form-app
```

## 3. Open the project in your preferred code editor

## 4. Create a new component file for your form

Inside the `src` directory, create a new file called `MyForm.js` (or any name you prefer) and add the following code:

```jsx
import { useState } from 'react';

function MyForm() {
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    message: '',
  });

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormData((prevFormData) => ({
      ...prevFormData,
      [name]: value,
    }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(formData);
  };

  return (
    <form onSubmit={handleSubmit}>
      <label htmlFor="name">Name:</label>
      <input
        type="text"
        id="name"
        name="name"
        value={formData.name}
        onChange={handleChange}
      />

      <label htmlFor="email">Email:</label>
      <input
        type="email"
        id="email"
        name="email"
        value={formData.email}
        onChange={handleChange}
      />

      <label htmlFor="message">Message:</label>
      <textarea
        id="message"
        name="message"
        value={formData.message}
        onChange={handleChange}
      />

      <button type="submit">Submit</button>
    </form>
  );
}

export default MyForm;
```

This code sets up a basic form with `name`, `email`, and `message` fields, and handles the state management and submission using the `useState` hook.

## 5. Import the `MyForm` component in `App.js`

Open the `App.js` file in the `src` directory and import the `MyForm` component:

```jsx
import MyForm from './MyForm';

function App() {
  return (
    <div className="App">
      <MyForm />
    </div>
  );
}

export default App;
```

This will render the `MyForm` component inside the `App` component.

## 6. Start the development server

In your terminal, run the following command to start the development server:

```bash
npm start
```

This will start the development server and open your app in the browser at `http://localhost:3000`.

You should now see the form rendered on the page. You can interact with the form fields and submit the form to see the form data logged to the console.

Remember to replace the code in `MyForm.js` with your own form logic and styling as needed.