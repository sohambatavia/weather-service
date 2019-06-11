import React, { Component } from 'react';
import PropTypes from 'prop-types';
import ReactTable from 'react-table';
import 'react-table/react-table.css';
import {connect} from 'react-redux';
import {getCitites} from  '../actions/cityAction';

class CityDetails extends Component {
    
    componentWillMount() {
        this.props.getCitites();
    }

    static get propTypes() {
        return {
            cities: PropTypes.array.isRequired,
            loading: PropTypes.bool.isRequired,
            error: PropTypes.object,
            getCities: PropTypes.func
        }
    }

    render() {
        
        const columns = [{
            Header: 'Name',
            accessor: 'name'
          }, {
            Header: 'Temperature',
            accessor: 'temperature',
            Cell: props => <span className='number center'>{props.value}</span>
          }];

          let divContent = (
            <span>
                <ReactTable data={this.props.cities} columns={columns} />
            </span>
          );

          if (this.props.error) {
                divContent = (
                    <span>
                        {this.props.error.message}
                    </span>
                );
          }

          if (this.props.loading) {
                divContent = (
                    <span>
                        Please wait..
                    </span>
                );
          }
          
        return (
            <div>
               {divContent}
            </div>
        )
    }
}

const mapStateToProps = state => ({
    cities: state.cities.results,
    loading: state.cities.loading,
    error: state.cities.error
});

export default connect(mapStateToProps, {getCitites})(CityDetails);