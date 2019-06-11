import {GET_CITIES_BEGIN, GET_CITIES_SUCCESS, GET_CITIES_FAILURE} from '../constants/actionTypes'

export function getCitites() {
   
    return function(dispatch) {
        dispatch({
            type: GET_CITIES_BEGIN
        });
        fetch('http://localhost:8080/temperature/city')
        .then(handleErrors)
        .then(response => response.json())
        .then(result => dispatch({
            type: GET_CITIES_SUCCESS,
            data: result
        }))
        
        .catch(error => dispatch({
            type: GET_CITIES_FAILURE,
            data: error
        }));
    }
}

function handleErrors(response) {
    if (!response.ok) {
        return response.json().then(error => {throw error;})
    }
    return response;
  }