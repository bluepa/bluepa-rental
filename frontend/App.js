import React, {Component} from 'react';
import {Platform, StyleSheet, Text, View} from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import LoginPage from './login/LoginPage';
import JoinPage from './login/JoinPage';
import StartPage from './login/StartPage';

const Stack = createStackNavigator();

function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Start" component={StartPage} />
        <Stack.Screen name="Login" component={LoginPage} />
        <Stack.Screen name="Join" component={JoinPage} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default App;