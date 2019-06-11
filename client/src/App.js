import React from 'react';
import './App.css';
import CityDetails from './components/CityDetails';
import {Provider} from 'react-redux';
import store from './store'

function App() {
  return (
    <Provider store={store}>
      <div className="App">
        <CityDetails />
      </div>
    </Provider>
  );
}

export default App;
