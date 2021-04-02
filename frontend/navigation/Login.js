import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import JoinScreen from '../screens/Login/JoinScreen'
import EmailJoinScreen from '../screens/Login/EmailJoinScreen'
import StartScreen from '../screens/Login/StartScreen'

const Stack = createStackNavigator();


function Login() {

    return (
        <NavigationContainer>
            <Stack.Navigator>
                <Stack.Screen name="Start" component={StartScreen} options={{
                    title: ' ',
                    headerStyle: { backgroundColor: '#333333', shadowColor: 'transparent'},
                }} />
                <Stack.Screen name="Join" component={JoinScreen} options={{
                    title: ' ',
                    headerStyle: { backgroundColor: '#333333', shadowColor: 'transparent'},
                }} />
                <Stack.Screen name="EmailJoin" component={EmailJoinScreen} options={{
                    title: ' ',
                    headerStyle: { backgroundColor: '#333333', shadowColor: 'transparent'},
                }} />
            </Stack.Navigator>
        </NavigationContainer>
    );
}
export default Login;