
import React, { Component, useState } from 'react';
import { View, Button, StyleSheet } from 'react-native';
import Fade from 'react-native-fade'

const LoginLayout = ({ navigation }) => {
    const [visible, setVisible] = useState(false);
    if (!visible) {
        return (
            <Fade visible={!visible} direction="down">
                <Button
                    buttonColor={'#444'}
                    title={'시작하기'}
                    onPress={() => setVisible(true)} />
            </Fade>
        );
    }
    else {
        return (
            <Fade visible={visible} direction="down">
                <View style={styles.Btn}>
                    <Button
                        title={'Google로 계속'}
                        onPress={() => alert('확인 버튼')} />
                </View>
                <View style={styles.Btn}>
                    <Button
                        color='#3B5998'
                        title={'Facebook으로 계속'}
                        onPress={() => alert('확인 버튼')} /></View>
                <View style={styles.Btn}>
                    <Button
                        color='#fcd411'
                        title={'Kakao로 계속'}
                        onPress={() => alert('확인 버튼')} /></View>

                <View style={styles.Btn}>
                    <Button
                        buttonColor={'#444'}
                        title={'Email로 계속'}
                        onPress={() => navigation.navigate('EmailJoin')} />
                </View>

            </Fade>
        );
    }
}
const styles = StyleSheet.create({
    Btn: {
        margin: 10,
    },
})
export default LoginLayout;