import {GET_CITIES_BEGIN, GET_CITIES_SUCCESS, GET_CITIES_FAILURE} from '../constants/actionTypes'

const initState = {
    results: [],
    loading: false,
    error: null
}

export default function(state = initState, action) {
    
    switch(action.type) {
        
        case  GET_CITIES_BEGIN :
        return {
                ...state,
                loading: true,
                error: null
            };

        case  GET_CITIES_SUCCESS :  
        return {
                ...state,
                loading: false,
                results: action.data
            };

        case  GET_CITIES_FAILURE :
        return {
                ...state,
                loading: false,
                results: [],
                error: action.data
            };
        
        default:
            return state;

    } 
    
}