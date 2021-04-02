import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import LoginScreen from '../screens/Login/LoginScreen'
import JoinScreen from '../screens/Login/JoinScreen'
import StartScreen from '../screens/Login/StartScreen'


const Stack = createStackNavigator();


function Login() {
    
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Start" component={StartScreen} />
        <Stack.Screen name="Login" component={LoginScreen} />
        <Stack.Screen name="Join" component={JoinScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

export default Login;