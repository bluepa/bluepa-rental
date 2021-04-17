import React, { Component,useState} from 'react';
import { StyleSheet, Text, View, TextInput } from 'react-native';
import Fade from 'react-native-fade'

const SimpleInput =({description,placeholder,onSubmitEditing}) => {
    const [visible, setVisible] = useState(false);
    const [typing, setTyping] = useState(false);
    const [text, setText] = useState('');
    return (
        <View>
            <Fade visible={visible} direction="up">
                <Text style={styles.textAni}>{placeholder}</Text>
            </Fade>
            <View style={styles.wrap}>
                <TextInput
                    style={styles.input}
                    placeholder={placeholder}
                    placeholderTextColor="lightgray"
                    color="lightgray"
                    onSubmitEditing = {onSubmitEditing}
                    onChangeText={text => {
                        setText(text);
                        if(!typing && text.length >0){
                            setTyping(true);
                            setVisible(!visible);
                        }
                        if (text.length <1){
                            setTyping(false);
                            setVisible(!visible);
                        }

                    }}
                    />
            </View>
            <View>
                <Text style={styles.description}>{description}</Text>
            </View>
        </View>
        
    )
}
SimpleInput.defaultProps = {
    description: '주소를 확인하기위한 이메일을 보내드리겠습니다.',
    placeholder:"내 이메일 주소",
    color:'lightgray',
    onSubmitEditing: () => null,
}
export default SimpleInput;
const styles = StyleSheet.create({
    textAni:{
        color :'lightgrey',
    },
    wrap: {
        flexDirection: 'row', justifyContent: 'space-between', alignItems: 'center', paddingBottom: 10,
    },
    input: {
         width: '70%', height: 35, borderWidth: 0, padding: 0,fontSize:25,
    },
    description: {
        fontSize: 15,
        color:'lightgray',
    },

});