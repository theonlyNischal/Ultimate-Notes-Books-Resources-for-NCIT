.model small
.stack 100h
.data
    number dw 9534h
    positivemsg db "positive$"
    negativemsg db "negative$"

.code
    main proc
        .startup
        mov ax,number
        test ax,1000000000000000b
        jz positive
        lea dx,negativemsg
        mov ah,09h
        int 21h
        jmp last
        
        positive:
        lea dx,positivemsg
        mov ah,09h
        int 21h
        last:
        .exit
        
    main endp
    end main
         