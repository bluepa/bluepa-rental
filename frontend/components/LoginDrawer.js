import React from 'react';
import { View, Text } from 'react-native';
import BottomDrawer from 'rn-bottom-drawer';

const TAB_BAR_HEIGHT = 49;

export default class App extends React.Component {
  renderContent = () => {
    return (
      <View>
        <Text>Get directions to your location</Text>
      </View>
    )
  }

  render() {
    return (
      <BottomDrawer
        containerHeight={100}
        offset={TAB_BAR_HEIGHT}
      >
        {this.renderContent()}
      </BottomDrawer>
    )
  }
}