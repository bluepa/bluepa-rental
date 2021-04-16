
import React, { useState } from 'react';
import { Text,View, Button, StyleSheet } from 'react-native';
import BoxInput from '../components/BoxInput';
import WhiteInput from '../components/WhiteInput';
import Icon from 'react-native-vector-icons/FontAwesome5';

const myIcon1 = <Icon name="comments" size={30} color="#900" />;
const SigninLayout = ({ navigation }) => {
    return(
        <View>
            <BoxInput >
              </BoxInput>
              <BoxInput>
              </BoxInput>
              <Button style={styles.Btn} title='이메일 확인'></Button>
              <Text>{myIcon1}</Text>
        </View>
    );
}
const styles = StyleSheet.create({
    Btn: {
        padding: 10,
    },
})
export default SigninLayout;