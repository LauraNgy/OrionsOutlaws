import React from 'react';
import Header from '../components/header';
import MapContainer from './maps/GoogleApiWrapper';

const Home = props => {
  return(
    <div>
      <Header title="Home" />
      <MapContainer />
    </div>
  )
}
export default Home;
