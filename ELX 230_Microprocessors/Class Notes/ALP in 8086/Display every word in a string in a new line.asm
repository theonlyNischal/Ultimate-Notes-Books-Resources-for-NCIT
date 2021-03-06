.model small
.stack 100h
.data
    string db 'i love programming','$'
.code
    main proc
        .startup
        
        lea si,string
        forever:
            mov dl,[si]
            inc si
            cmp dl,' '    
            jne skipnewline
                mov dl, 0ah ;0a: new line (10)
                int 21h
                mov dl, 0dh ;0d: beginning of line (carriage return) (13)
            skipnewline:
            cmp dl,'$'
            je last     
            mov ah,02h
            int 21h
            jmp forever
        last:
        mov ah,4ch
        int 21h      
    main endp
    end main
        
