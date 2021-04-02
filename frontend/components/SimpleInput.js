import React, { Component } from 'react';
import { StyleSheet, Text, View, TextInput } from 'react-native';

export default class SimpleInput extends Component {
    static defaultProps = {
        description: '주소를 확인하기위한 이메일을 보내드리겠습니다.',
        placeholder:"내 이메일 주소",
        color:'lightgray',
    }

    constructor(props) {
        super(props);
    }
    render() {
        return (
            <View>
                <View style={styles.wrap}>
                    <TextInput
                        style={styles.input}
                        placeholder={this.props.placeholder}
                        placeholderTextColor="lightgray" />
                </View>
                <View>
                    <Text style={styles.description}>{this.props.description}</Text>
                </View>
            </View>
            
        )
    }
}
const styles = StyleSheet.create({
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